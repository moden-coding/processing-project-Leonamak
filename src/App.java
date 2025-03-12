import processing.core.*;

public class App extends PApplet {
    boolean BGpress = false;
    int brush = 20;

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
                fill(0, 0, 0);
                noStroke();
                rect(220, 0, 600, 150);
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
        // red circle
        stroke(230, 230, 230);
        strokeWeight(2);
        fill(200, 0, 0);
        ellipse(75, 55, 60, 60);
        // orange circle
        stroke(230, 230, 230);
        strokeWeight(2);
        fill(255, 159, 0);
        ellipse(75, 135, 60, 60);
        // yellow circle
        stroke(230, 230, 230);
        strokeWeight(2);
        fill(255, 240, 5);
        ellipse(75, 135 + 80, 60, 60);
        // green circle
        stroke(230, 230, 230);
        strokeWeight(2);
        fill(90, 220, 80);
        ellipse(75, 135 + 160, 60, 60);
        // blue circle
        stroke(230, 230, 230);
        strokeWeight(2);
        fill(144, 213, 255);
        ellipse(75, 135 + 240, 60, 60);
        // purple-blue circle
        stroke(230, 230, 230);
        strokeWeight(2);
        fill(120, 145, 240);
        ellipse(75, 135 + 320, 60, 60);
        // indigo circle
        stroke(230, 230, 230);
        strokeWeight(2);
        fill(150, 85, 230);
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
        textSize(15);
        text("Change BG", 1000 - 105, 280);
        // brush thickness button
        fill(200, 200, 200);
        rect(890, 320, 75, 50);
        fill(0, 0, 0);
        textSize(12);
        text("Change Brush", 1000 - 107, 350);

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
                System.out.println("resetted");
            } else if (isBGButtonPressed()) {
                background(0, 0, 0);
                System.out.println("changed");
            } else if (mouseY < 370 && mouseY > 320) {

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
        boolean press = false;
        if (mousePressed) {
            if (mouseX > 880 && mouseX < 965 && mouseY > 180 && mouseY < 250) {
                press = true;
            } else {
                press = false;
            }
        }
        return press;

    }

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

    // checks to see if the thickness buttons are pressed.
    public int ThicknessPressed() {
        if (mousePressed) {
            if (mouseX > 880 && mouseX < 965 && mouseY > 320 && mouseY < 370) {
                if (brush == 50) {
                    brush = 20;
                } else {
                    brush = brush + 10;
                }
            }
        }
        return brush;
    }

    // makes the brush actually work only inside the canvas. i used chatGPT to find
    // out what the mouseDragged
    // method was, everything inside was written by me.
    public void mouseDragged() {
        // making sure that you cant draw where the color pallete is
        if (mouseX > 115 && mouseX < 890) {
            noStroke();
            fill(mycolor);
            circle(mouseX, mouseY, );
            System.out.println(ThicknessPressed());
            System.out.println("nice");
        }
    }
}
