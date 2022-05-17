
   public class OrbNode {
       float x, y;
       float dx, dy;
       float radius;
       color c;
       OrbNode next, prev;

       //default constructor 
       public OrbNode() {}

       public OrbNode(float x_, float y_) {
           this(x_, y_, 0.0, 0.0, 50.0);
       }

       public OrbNode(float x_, float y_, float dx_, float dy_, float radius_) {
           x = x_;
           y = y_;
           dx = dx_;
           dy = dy_;
           radius = radius_;
           c = color(random(255), random(255), random(255), 200);
       }

       void display() {
           fill(c);
           ellipse(x, y, radius * 2, radius * 2);
           if (next != null || prev != null) {
               if (next != null) {
                   //if next has value do this. 
                   line(x, y, next.x, next.y);
               }
               if (prev != null) {
                   // if prev has value do this. 
                   line(x, y, prev.x, prev.y);
               }
           }
       }

       void move() {
           prev.springAttract(this);
           next.springAttract(this);
           x += dx;
           y += dy;
           dy = dy + g;
       }

       void springAttract(OrbNode other) {
           float dist = dist(x, y, other.x, other.y);
           float force = (dist - S_L) * S_C;
           float displacex = (x - other.x);
           float displacey = (y - other.y);
           other.dx += displacex * force / dist;
           other.dy += displacey * force / dist;
           other.dx *= S_D;
           other.dy *= S_D;
       }
   }

   public class FixedOrbNode extends OrbNode {
       void move() {}
       FixedOrbNode(float x_, float y_) {
           x = x_;
           y = y_;
           radius = 30;
           c = color(0);
       }
   }
