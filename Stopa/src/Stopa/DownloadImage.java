package Stopa;

import java.awt.image.RenderedImage;
import javafx.scene.image.WritableImage;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import java.io.*;
import javax.imageio.ImageIO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.canvas.Canvas;



public class DownloadImage implements Initializable {
    String t1, t2, t3, t4, t5, s1,s2,s3;
    @FXML
    private ImageView Image_method;
    @FXML
    private ImageView form_im;
    double x1, x2, y1, y2;
    int i,s = 0;
    @FXML
    private Canvas work_line;

    @FXML
    private Image image;

    @FXML
    private TextField a;
    @FXML
    private TextField b;
    @FXML
    private TextField c;

    @FXML
    private TextField d;

    @FXML
    private TextField k;

    @FXML
    private TextField S1;
    @FXML
    private TextField S2;
    @FXML
    private TextField S3;

    Canvas canvas;
    Line line = new Line();
    @FXML
    private TextField res;
    @FXML
    private TextField res1;

    private GraphicsContext gc;

    private FileChooser filechooser = new FileChooser();

    File file_download;
    File filek;



    @FXML
    private void Canvas_download(Canvas canvas, Image image_d)
    {
        gc = canvas.getGraphicsContext2D();
        if(canvas.getHeight() >= image_d.getHeight() && canvas.getWidth()>= image_d.getWidth())
        {
            gc.drawImage(image_d, 0, 0,image_d.getWidth(), image.getHeight());
        }
        else{
            gc.drawImage(image_d, 0, 0, canvas.getWidth(), canvas.getHeight());
        }
    }

    public void download_image()
    {
        file_download = filechooser.showOpenDialog(null);
        String file = file_download.getPath();
        image = new Image(file);
        GraphicsContext canvas = work_line.getGraphicsContext2D();
        canvas.clearRect(0, 0, work_line.getWidth(), work_line.getHeight());
        Canvas_download(work_line, image);
        gc = work_line.getGraphicsContext2D();
    }

    public void method_shtritera()
    {
        String file_method = "C:\\Users\\256bit.by\\IdeaProjects\\Stopa\\src\\Stopa\\method_1.png";
        Image image1 = new Image(file_method);
        Image_method.setImage(image1);

        String file_meth = "C:\\Users\\256bit.by\\IdeaProjects\\Stopa\\src\\Stopa\\form_1.png";
        Image image2 = new Image(file_meth);
        form_im.setImage(image2);

        work_line.setOnMousePressed(e ->
        {
            line.setStartX(e.getX());
            x1 = line.getStartX();
            line.setStartY(e.getY());
            y1 = line.getStartY();

        });


        work_line.setOnMouseReleased(e -> {

            line.setEndX(e.getX());
            x2 = line.getEndX();
            line.setEndY(e.getY());
            y2 = line.getEndY();
            gc.strokeLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());

            double result = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
            String str = Double.toString(result);
            switch (s)
            {
                case 0:
                {
                    S1.setText(str);
                    s1 = S1.getText();
                    break;
                }
                case 1:
                {
                    S2.setText(str);
                    s2 = S2.getText();
                    break;
                }
                case 2:
                {
                    S3.setText(str);
                    s3 = S3.getText();
                    s = -1;
                    break;
                }
            }

            s++;
            //Double pt1 = Double.valueOf(s1);
            Double ppt2 = Double.valueOf(s2);
            Double ppt3 = Double.valueOf(s3);
            Double resi = (ppt3 * 100) / ppt2;
            String h = Double.toString(resi);
            res1.setText(h);
        });
    }

    public void method_chizheva() {
        String file_method = "C:\\Users\\256bit.by\\IdeaProjects\\Stopa\\src\\Stopa\\method_2.png";
        Image image1 = new Image(file_method);
        Image_method.setImage(image1);
        String file_meth = "C:\\Users\\256bit.by\\IdeaProjects\\Stopa\\src\\Stopa\\form_2.png";
        Image image2 = new Image(file_meth);
        form_im.setImage(image2);

        Line line = new Line();
        work_line.setOnMousePressed(e -> {
            line.setStartX(e.getX());
            x1 = line.getStartX();
            line.setStartY(e.getY());
            y1 = line.getStartY();
        });

        work_line.setOnMouseReleased(e -> {
            line.setEndX(e.getX());
            x2 = line.getEndX();
            line.setEndY(e.getY());
            y2 = line.getEndY();
            gc.strokeLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());

            double result = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
            String str = Double.toString(result);
            switch (i) {
                case 0: {
                    a.setText(str);
                    t1 = a.getText();
                    break;
                }
                case 1: {
                    b.setText(str);
                    t2 = b.getText();
                    break;
                }
                case 2: {
                    c.setText(str);
                    t3 = c.getText();
                    break;

                }
                case 3: {
                    d.setText(str);
                    t4 = d.getText();
                    break;

                }
                case 4: {
                    k.setText(str);
                    t5 = k.getText();
                    i = -1;
                    break;
                }
            }

            i++;
            //Double pt1 = Double.valueOf(t1);
            //Double pt2 = Double.valueOf(t2);
            //Double pt3 = Double.valueOf(t3);
            Double pt4 = Double.valueOf(t4);
            Double pt5 = Double.valueOf(t5);
            Double resi = pt4 / pt5;
            String h = Double.toString(resi);
            res.setText(h);

        });
    }

    @FXML
    public void clear_canvas()
    {
        GraphicsContext context = work_line.getGraphicsContext2D();
        context.clearRect
                (
                0,
                0,
                work_line.getWidth(),
                work_line.getHeight());
    }

    public void save(ActionEvent event)
    {
        FileChooser savefile = new FileChooser();
        savefile.setTitle("Save File");
        filek= savefile.showSaveDialog(null);
        try
        {
            WritableImage writableImage = new WritableImage((int)work_line.getWidth()-((int)work_line.getWidth()-(int)image.getWidth()), (int)work_line.getHeight()-((int)work_line.getHeight()-(int)image.getHeight()));
            work_line.snapshot(null, writableImage);
            RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
            ImageIO.write(renderedImage, "png", filek);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void clear_text()
    {
        a.clear();
        b.clear();
        c.clear();
        d.clear();
        k.clear();

        res.clear();
        res1.clear();

        S1.clear();
        S2.clear();
        S3.clear();

        s=0;
        i=0;
    }


    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        gc = work_line.getGraphicsContext2D();
        gc.setFill(Color.rgb(255,255,255,0.45));
        gc.fillRect(0,0, work_line.getWidth(), work_line.getHeight());
    }

    /*
    public void main()
    {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new GoodFeaturesToTrack();
            }
        });
    }*/
}

