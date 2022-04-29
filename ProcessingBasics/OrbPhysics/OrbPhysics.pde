ArrayList < Orb > orbs;

boolean background = true;
final int BOUNCE = 0;
final int ORBIT = 1;
final int SPRING = 2;
final float SPRING_LENGTH = 140;
final float SPRING_DAMPEN = 0.899;
final float SPRING_CONSTANT = 0.020;
boolean gravitySwitch = true;
Orb middle;
int MODE = SPRING - 2;

void setup() {
    size(1000, 800);
    orbs = new ArrayList < Orb > ();
    middle = new Orb(500, 400, 0, 0, 10);
}

void mouseClicked() {
    Orb test = new Orb(mouseX, mouseY, 5, 0, 20);
    orbs.add(test);
}

void draw() {
    if (background) {
        background(255);
    }

    if (background == false) {
        fill(255);
        rect(0, 0, 150, 110);
    }
    middle.display();


    for (Orb tester: orbs) {
        tester.move();

        if (gravitySwitch == true) {
            tester.dy += 0.15;
        } else if (MODE == ORBIT) {
            middle.attract(tester);
        } else if (MODE == BOUNCE) {
            tester.bounce();
        } else if (MODE == SPRING) {
            middle.attractSpring(tester);
        }

        tester.display();
    }

    fill(0);
    text(frameRate, 20, 20);
    text(orbs.size(), 20, 40);

    if (MODE == 0) text("MODE: GRAVITY", 20, 60);
    else if (MODE == 1) text("MODE: ORBIT", 20, 60);
    else if (MODE == 2) text("MODE: SPRING", 20, 60);


    if (gravitySwitch) {
        text("GRAVITY: ON", 20, 80);
    } else if (!gravitySwitch) {
        text("GRAVITY: OFF", 20, 80);
    }

    if (background) {
        text("BACKGROUND: On", 20, 100);
    }
    if (!background) {
        text("BACKGROUND: Off", 20, 100);
    }
}

void keyPressed() {
    if (key == BACKSPACE) orbs.clear();
    // space key 
    if (key == ' ') {
        MODE += 1;
        if (MODE > 2) {
            MODE = 0;
        }
    }
    // second key
    if (key == 'b') {
        background = !background;
    }
    // last one 
    if (key == 'g') {
        gravitySwitch = !gravitySwitch;
    }
}



public class Orb {
    float x, y;
    float dx, dy;
    float radius;
    color c;

    public Orb(float x_, float y_, float xSpeed_, float ySpeed_, float radius_) {
        x = x_;
        y = y_;
        dx = xSpeed_;
        dy = ySpeed_;
        radius = radius_;
        c = color(random(255), random(255), random(255));
    }

    void display() {
        fill(c);
        //noStroke();
        circle(x, y, radius * 2);
        float temp = 5 * dx;
        float temp2 = 5 * dy;
        line(x, y, x + (temp), y + (temp2));
    }

    void bounce() {
        float diff = width - radius;
        float diff2 = height - radius;

        if (x >= diff || x <= radius) {
            dx *= -1;
        }
        if (y >= diff2 || y <= radius) {
            dy *= -1;
        }

        float temp = height - radius;
        if (y > temp) {
            y = temp;
        }
        float temp2 = radius;
        if (y < temp2) {
            y = temp2;
        }

    }

    void move() {
        x += dx;
        y += dy;
    }


    void attract(Orb orb2) {
        float distanceEach = dist(orb2.x, orb2.y, x, y);

        if (distanceEach != 0) {
            double temp = Math.pow(distanceEach, 2);
            orb2.dy += 20 * (y - orb2.y) / (temp);
            orb2.dx += 20 * (x - orb2.x) / (temp);
        }
    }

    void attractSpring(Orb orb2) {
        float distance = dist(x, y, orb2.x, orb2.y);
        float force = (distance - SPRING_LENGTH) * SPRING_CONSTANT;

        orb2.dx += (force * (x - orb2.x)) / (distance);
        orb2.dy += (force * (y - orb2.y)) / (distance);
        orb2.dx = orb2.dx * SPRING_DAMPEN;
        orb2.dy = orb2.dy * SPRING_DAMPEN;

    }
}
