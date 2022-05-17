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
