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
       else if(C_M == 1){ 
        listorbs.add(mouseX, new OrbNode(mouseX, mouseY,0,0,30)); 
       } 
       else if(C_M == 2){ 
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
       if(C_M == 0){ 
       text("click mode: " + "add", 19, 99); 
       }
       if(C_M == 1){ 
       text("click mode: " + "insert", 19, 99); 
       } 
       if(C_M == 2){ 
       text("click mode: " + "delete", 19, 99); 
       } 
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
       
       if (key == '8') {
               g = g * (change - 0.02);
       }

   }
