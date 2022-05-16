   static int S = 2;
   static float S_L = 50;
   static float S_D = 0.990;
   static float S_C = 0.015;
   static int M = S;
   static float g = 0.40; 
  OrbList orbs;
  
  void setup() {
      size(1000, 800);
      orbs = new OrbList();
  }
  
  void mouseClicked() {
      orbs.add(new OrbNode(mouseX, mouseY, 0, 0, 30));
  }
  void draw() {
      background(255);
      orbs.processAll();
      orbs.display();
      
      
      // code to display test, representing values. 
      text( "spring length: " + S_L, 19, 59); 
      text( "gravity: " + g, 19, 79);
      text( "spring constant: " + S_C, 19, 19); 
      text( "spring dampen: " + S_D, 19, 39);       
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
          //If next or previous exist, draw lines to them! (aim for slightly off center)
          /*you write this part*/
          if(next != null || prev != null){ 
            if(next!= null){
              //if next has value do this. 
              line(x,y,next.x,next.y);
            }
            if(prev != null){
              // if prev has value do this. 
              line(x,y,prev.x,prev.y);
            }
          } 
      }

      void move() {
          //have prev and next apply spring force to this node;
          /*you write this part*/
          prev.springAttract(this);
          next.springAttract(this);
          //apply velocity to position
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
  
  //this COULD be a separate tab but is small enough
  //that it doesn't matter for organizational purposes.
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
      OrbNode first, last;

      //create a fixed orb
      OrbList() {
          first = new FixedOrbNode(0, height / 5);
          last = new FixedOrbNode(width, height / 5);
          //link them to eachother
          first.next = last;
          last.prev = first;
      }

      /**
       *complete this method
       */
      void add(OrbNode node) {
          node.prev = last.prev;
          //insert orb at the end of the list before the last node.
          node.prev.next = node;
          // after this have to set next to last 
          node.next =last; 
          //then set prev of last to node?
          last.prev = node;
          
      }

      /**
       *complete this method
       *process all nodes by running move.
       */
      void processAll() {
          OrbNode current = first;
          //advance current to next until it is null, move() each of the nodes
      }
      /**
       *complete this method
       *Display all nodes by running their display().
       */
      void display() {
          OrbNode current = first;
          //advance current to next until it is null, display() each of the nodes
      }
  }
