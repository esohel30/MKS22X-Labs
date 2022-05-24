String[]titles;
Kernel[]kernels;
int current;

void setup() {
  size(1450, 500);
  current = 0;
  titles = new String[]{
    "Identity", "Blur", "Sharpen", 
    "Outline", "Left Sobel", "Right Sobel", 
    "Top Sobel", "Emboss"
  };
  kernels = new Kernel[] {
    new Kernel( new float[][] {
      {0, 0, 0}, 
      {0, 1, 0}, 
      {0, 0, 0}
    }), 
    new Kernel( new float[][] {
      {.111, .111, .111}, 
      {.111, .111, .111}, 
      {.111, .111, .111}
    }), 
    new Kernel( new float[][] {
      {0, -1, 0}, 
      {-1, 5, -1}, 
      {0, -1, 0}
    }), 
    new Kernel( new float[][] {
      {-1, -1, -1}, 
      {-1, 8, -1}, 
      {-1, -1, -1}
    }), 
    new Kernel( new float[][] {
      {1, 0, -1}, 
      {2, 0, -2}, 
      {1, 0, -1}
    }), 
    new Kernel( new float[][] {
      {-1, 0, 1}, 
      {-2, 0, 2}, 
      {-1, 0, 1}
    }), 
    new Kernel( new float[][] {
      {1, 2, 1}, 
      {0, 0, 0}, 
      {-1, -2, -1}
    }), 
    new Kernel( new float[][] {
      {-2, -1, 0}, 
      {-1, 1, 1}, 
      {0, 1, 2}
    })
  };
}

void draw() {
  PImage c = loadImage("redcar.png");
  PImage o = c.copy();
  kernels[current].apply(c, o); 
  image(c, 0, 0); 
  image(o, c.width, 0);
  text("Kernel: " + titles[current], 20, 20);
  fill(0);
}

void keyPressed() { 
  if (current + 1 > 7) {
    current = 0;
  } else { 
    current = current + 1;
  }
}
