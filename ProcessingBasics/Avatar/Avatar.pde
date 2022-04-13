void avatar(int x, int y){
  fill(x*y,x,255-x);
  rect(x,y,150,150);
  fill(x*y,x,255-x);
  stroke(33);
  circle(x,y, 70);
  fill(x,x,255-x);
  circle(x + 150,y, 70);
  stroke(0);
  fill(y,x,255-x);
  circle(x + 40, y + 40, 20);
  stroke(0);
  fill(x*y,x,255);
  circle(x + 110, y + 40, 20);
  ellipse(x,y,20,40);
  ellipse(x+150,y,20,40);
  rect(x + 20, y + 80, 120, 10);
}

  int x,y;
  int MODE;
  void setup(){
           size(800,800);
           MODE = 1;
           x = width/2;
           y = height/2;
  }
  
  void draw(){
           background(255);
           x = change(x);
           y = change(y);
           avatar(x,y);
  }
 
  int change(int value){
    /**
     mode 1: return a random location on the screen.
     mode 2: change value by +1, 0, or -1 randomly
     mode 3: change value by +1 , but if it goes past the end of the screen ,
           wrap back around to the other end of the screen.
    */
   

    switch(MODE){
     case 1:
        avatar( (int) (Math.random() * width)  -150, 100 + (int) ((Math.random() * height)) -150);
     case 2:
        avatar( 400 +(int) (Math.random() *2)  -1, 400+  (int) ((Math.random() * 2)) -1);
     case 3:
     
       int i =200; 
       avatar(i,400);
       
     
       
    
       
       
     default:
      return 1;
}
   
   
   
  }
