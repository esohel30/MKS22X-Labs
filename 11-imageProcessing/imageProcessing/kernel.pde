public class Kernel {
      float[][]data;

      /**Constructor takes the kernel that will be applied to the image
      *This implementation only allows 3x3 kernels
      */
      public Kernel(float[][]n) {
        data = n; 
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
        
        if(x == start || y == start || x == temp || y == temp2){ 
          return black ; 
        }
        for(int a = 0; a < data.length; a++){ 
          for(int b =0; b <data[a].length; b++){ 
          }
        }
        
        
        
        
        
        
        
        
        return 1; 

      }

      /**You must write this method that applies the kernel to the source,
      *and saves the data to the destination.*/
      void apply(PImage source, PImage destination) {
        
        
        source = destination; 
        destination = source; 
      }

    }
