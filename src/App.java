import processing.core.*;

public class App extends PApplet {
    boolean BGpress = false;
    int brush = 20;
    boolean press = false;
    boolean opacity = false;
    int myopacity = 255;
    float i = 0;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    // background color
    public void setup() {
        background(255, 255, 255);
    }

    // setting the size of the canvas
    public void settings() {
        size(1000, 1000);
    }

    // the main setup of my color pallette and buttons.
    public void draw() {
        // System.out.println(frameCount);
        // my letters
        // this little piece of code makes them dissapear after 5 seconds and never come
        // back!
        if (frameCount == 250) {
            if (isBGButtonPressed()) {
                if (isResetButtonPressed()) {
                    System.out.println("should be white");
                fill(255,255,255);
                noStroke();
                rect(220, 0, 600, 150);
            } else {
                fill(0, 0, 0);
                noStroke();
                rect(220, 0, 600, 150);}
            } else {
                fill(255, 255, 255);
                noStroke();
                rect(220, 0, 600, 150);
            }
        } else if (frameCount < 250) {
            fill(90, 10, 20);
            textSize(60);
            text("welcome to art class!", 240, 60);
            textSize(30);
            text("select a color, and draw!", 350, 90);
        }
        // Color Pallete!
        //Red circle
        stroke(230, 230, 230);
        strokeWeight(2);
        fill(200, 0, 0);
        int red = color(200,0,0);
        ellipse(75, 55, 60, 60);
        // orange circle
        stroke(230, 230, 230);
        strokeWeight(2);
        fill(255, 159, 0);
        int orange = color(255,159,0);
        ellipse(75, 135, 60, 60);
        // yellow circle
        stroke(230, 230, 230);
        strokeWeight(2);
        fill(255, 240, 5);
        int yellow = color(255,240,5);
        ellipse(75, 135 + 80, 60, 60);
        // green circle
        stroke(230, 230, 230);
        strokeWeight(2);
        fill(90, 220, 80);
        int green = color(90,220,80);
        ellipse(75, 135 + 160, 60, 60);
        // blue circle
        stroke(230, 230, 230);
        strokeWeight(2);
        fill(144, 213, 255);
        int blue = color(144,213,255);
        ellipse(75, 135 + 240, 60, 60);
        // purple-blue circle
        stroke(230, 230, 230);
        strokeWeight(2);
        fill(120, 145, 240);
        int bluepurple = color(120,145,240);
        ellipse(75, 135 + 320, 60, 60);
        // indigo circle
        stroke(230, 230, 230);
        strokeWeight(2);
        fill(150, 85, 230);
        int purple = color(150,85,230);
        ellipse(75, 135 + 400, 60, 60);
        // pink circle
        stroke(230, 230, 230);
        strokeWeight(2);
        fill(240, 135, 250);
        ellipse(75, 135 + 480, 60, 60);
        // brown circle
        stroke(230, 230, 230);
        strokeWeight(2);
        fill(80, 60, 30);
        ellipse(75, 135 + 560, 60, 60);
        // grey circle
        stroke(230, 230, 230);
        strokeWeight(2);
        fill(190, 190, 190);
        ellipse(75, 135 + 640, 60, 60);
        // white circle
        stroke(210, 210, 210);
        strokeWeight(2);
        fill(255, 255, 255);
        ellipse(1000 - 75, 55, 60, 60);
        // black circle
        stroke(90, 90, 90);
        strokeWeight(2);
        fill(0, 0, 0);
        ellipse(1000 - 75, 55 + 80, 60, 60);
        // reset button
        fill(200, 200, 200);
        rect(890, 180, 75, 50);
        fill(0, 0, 0);
        textSize(30);
        text("Reset", 1000 - 105, 55 + 160);
        // bg change button
        fill(200, 200, 200);
        rect(890, 250, 75, 50);
        fill(0, 0, 0);
        textSize(18);
        text("Black BG", 1000 - 105, 280);
        // brush thickness button
        fill(200, 200, 200);
        rect(890, 320, 75, 50);
        fill(0, 0, 0);
        textSize(12);
        text("Change Brush", 1000 - 107, 350);
        // opacity change button
        fill(200, 200, 200);
        rect(890, 390, 75, 50);
        fill(0, 0, 0);
        textSize(20);
        text("Opacity", 1000 - 104, 420);
        //pallete rectangle. only the first loop is written by ChatGPT, the rest i figured out myself.
        for (int i = 0; i < 50; i++) {
            float lerpValue = map(i, 0, 50, 0, 1);  // Map the y-position to a color interpolation value
            stroke(lerpColor(color(red), color(orange), lerpValue));  // Interpolate between red and orange
            line(890, 460 + i, 890 + 75, 460 + i);  // Draw a line across the rectangle at each y-position
          }
    }

    // selecting my color OR detecting the pressing of buttons
    int mycolor = 0;
    public void mousePressed() {
        if (mouseX < 115) {
            // colors on my left side
            noStroke();
            mycolor = get(mouseX, mouseY);
            fill(mycolor);
            System.out.println(mousePressed);
            System.out.println("gotten)");
            System.out.println(mycolor);
        } else if (mouseX > 880) {
            // colors on my right side AND my buttons
            if (isResetButtonPressed()) {
                background(255, 255, 255);
                myopacity = 255;
                brush = 20;
                System.out.println("resetted");
            } else if (isBGButtonPressed()) {
                background(0, 0, 0);
                System.out.println("changed");
            } else if (mouseY < 370 && mouseY > 320) {
                ThicknessPressed();
            } else if (isOpacityPressed()) {
                if (myopacity == 255) {
                    myopacity = 100;
                } else {
                    myopacity = 255;
                }
            } else {
                mycolor = get(mouseX, mouseY);
                if (mycolor == -1644826) {
                } else if (mycolor == -1) {
                } else {
                    fill(mycolor);
                    System.out.println(mousePressed);
                    System.out.println("gotten)");
                    System.out.println(mycolor);
                }
            }
        }
    }

    // checks to see if my reset button is pressed! i used a little bit of ChatGPT
    // to figure out
    // how i could make this method into a boolean.
    public boolean isResetButtonPressed() {
        
        if (mousePressed) {
            if (mouseX > 880 && mouseX < 965 && mouseY > 180 && mouseY < 250) {
                press = true;
            } else {
                press = false;
            }
        }
        return press;

    }
    //checks to see if the "Change bg" button is pressed.
    public boolean isBGButtonPressed() {
        if (mousePressed) {
            if (mouseX > 880 && mouseX < 965 && mouseY > 250 && mouseY < 300) {
                BGpress = true;
            } else {
                BGpress = false;
            }
        }
        return BGpress;
    }

    // checks to see if the thickness button is pressed.
    public int ThicknessPressed() {
        if (mousePressed) {
            if (mouseX > 880 && mouseX < 965 && mouseY > 320 && mouseY < 370) {
                    if (brush == 50) {
                        brush = 20;
                        System.out.println("Brush: " + brush);
                    } else {
                        brush += 10;
                        System.out.println("Brush: " + brush);
                    }
                
            }
        }
        return brush;
    }
    //changes opacity of the brush
    public boolean isOpacityPressed() {
        if (mousePressed) {
            if (mouseX > 880 && mouseX < 965 && mouseY > 370 && mouseY < 440) {
                opacity = true;
            } else {
                opacity = false;
            }
        }
        return opacity;
    }
    // makes the brush actually work only inside the canvas. i used chatGPT to find
    // out what the mouseDragged
    // method was, everything inside was written by me.
    public void mouseDragged() {
        // making sure that you cant draw where the color pallete is
        if (mouseX > 115 && mouseX < 890) {
            noStroke();
            fill(mycolor, myopacity);
            circle(mouseX, mouseY, brush);
        }
    }
}
