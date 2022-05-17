   static int S = 2;
   static float S_L = 51;
   static float S_D = 0.991;
   static float S_C = 0.016;
   static int M = S;
   static float g = 0.40;
   static int C_M = 0; 
   OrbList listorbs;

   void setup() {
       size(1000, 800);
       listorbs = new OrbList();
   }

   void mouseClicked() {
       if(C_M == 0){ 
       listorbs.add(new OrbNode(mouseX, mouseY, 0, 0, 30));
       } 
       if(C_M == 1){ 
        listorbs.add(new OrbNode(mouseX, mouseY,0,0,30)); 
       } 
       if(C_M == 2){ 
        listorbs.delete(listorbs.getNodeAt(mouseX, mouseY)); 
       }   
   }
   
   void draw() {
       background(255);
       listorbs.processAll();
       listorbs.display();


       // code to display test, representing values. 
       text("spring length: " + S_L, 19, 59);
       text("gravity: " + g, 19, 79);
       text("spring constant: " + S_C, 19, 19);
       text("spring dampen: " + S_D, 19, 39);
   }

   void keyPressed() {
     
       float change = 1.01; 
       
       if(key == ' '){ 
         C_M = C_M + 1; 
         if(C_M == 3){ // there are only three modes 
           C_M = 0; 
         }
       } 
       
       if (key == '1'){
           S_C = S_C * change;
       }
       
       if (key == '2') {
           if (S_C * (change-0.02) >= 0) {
               S_C = S_C * (change - 0.02);
           }
       }
       
       if (key == '3') {
         if(S_D * change < 1.0){ // to big starts acting weird
           S_D = S_D * change;
         }
       }
       
       if (key == '4') {
           if (S_D * (change -0.02) >= 0) {
               S_D = S_D * (change-0.02);
           }
       }
       
       if (key == '5') {
           S_L = S_L * change;
       }
       
       if (key == '6') {
           if (S_L * (change -0.02) >= 0) {
               S_L = S_L * (change - 0.02);
           }
       }
       
       if (key == '7') {
           g = g * change;
       }
       
       if (key == 8) {
           if (g * (change -0.02) >= 0) {
               g = g * (change -0.02);
           }
       }

   }


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


   public class OrbList {
       OrbNode f, l;

       //create a fixed orb
       OrbList() {
           f = new FixedOrbNode(0, height / 5);
           l = new FixedOrbNode(width, height / 5);
           //link them to eachother
           f.next = l;
           l.prev = f;
       }

       /**
        *complete this method
        */
       void add(OrbNode node) {
           node.prev = l.prev;
           //insert orb at the end of the list before the last node.
           node.prev.next = node;
           // after this have to set next to last 
           node.next = l;
           //then set prev of last to node?
           l.prev = node;
       }
       
       void add(int x, OrbNode t){ 
          OrbNode e = f; 
          while(e.next != null && x > e.x){ 
            e = e.next; 
          }
          e.prev.next = t; 
          t.prev = e.prev; 
          e.prev = t; 
          t.next = e;  
       } 
       
       void delete(OrbNode lockedon){ 
         if(lockedon != null){ 
           lockedon.prev.next = lockedon.next; 
           //this deletes what was there 
           lockedon.next.prev = lockedon.prev;
         }
       } 
       
       OrbNode getNodeAt(int corxpos, int corypos){ 
         OrbNode temp = f.next;
         OrbNode t = f. next; 
         int val = 25; 
         
         while(temp.next != null){ 
           if(dist(corxpos,corypos,temp.x, temp.y) < val){ 
             return temp; 
           } 
           temp = temp.next; 
         }
         return null;     
       } 
       

       /**
        *complete this method
        *process all nodes by running move.
        */
       void processAll() {
           //advance current to next until it is null, move() each of the nodes
           for (OrbNode c = f; c != null; c = c.next) {
               c.move();
           }
       }

       /**
        *complete this method
        *Display all nodes by running their display().
        */
       void display() {
           for (OrbNode c = f; c != null; c = c.next) {
               c.display();
           }
       }
   }
