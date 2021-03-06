public class Kernel {
  float[][]kern;

  /**Constructor takes the kernel that will be applied to the image
   *This implementation only allows 3x3 kernels
   */
  public Kernel(float[][]n) {
    kern = n;
  }

  /**If part of the kernel is off of the image, return black, Otherwise
   *Calculate the convolution of r/g/b separately, and return that color\
   *if the calculation for any of the r,g,b values is outside the range
   *     0-255, then clamp it to that range (< 0 becomes 0, >255 becomes 255)
   */

  color calcNewColor(PImage img, int x, int y) {
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
    int temp = img.width - 1; 
    int temp2 = img.height -1; 
    final int start = 0; 
    color black = color(0); 
    int red = 0, green = 0, blue = 0; 
    color og; 
    float t; 

    if (x == start || y == start || x == temp || y == temp2) { 
      return black ;
    }
    for (int a = 0; a < kern.length; a++) { 
      for (int b = 0; b <kern[a].length; b++) {
        og = img.get(x + b - 1, y + a - 1); 
        t = kern[a][b];
        red += red(og) * t; 
        green += green(og) * t; 
        blue += blue(og) * t;
      }
    }
    if (red < 0 || green < 0 || blue < 0) { 
      if (red < 0) { 
        red =0;
      } 
      if (green < 0) { 
        green =0;
      } 
      if (blue < 0) { 
        blue =0;
      }
    }
    if (red > 255 || green > 255 || blue > 255) { 
      if (red > 255) { 
        red = 255;
      } 
      if (green > 255) { 
        green = 255;
      } 
      if (blue  > 255) { 
        blue = 255;
      }
    }

    return color(red, green, blue);
  }

  /**You must write this method that applies the kernel to the source,
   *and saves the data to the destination.*/
  void apply(PImage s, PImage dest) {

    for (int a =0; a < s.width; a ++) { 
      for (int b = 0; b < s.height; b++) { 

        // must type cast the calc new color output to int. 
        dest.set(a, b, (int) calcNewColor(s, a, b));
      }
    }
  }
}
