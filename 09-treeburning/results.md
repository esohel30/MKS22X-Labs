# **Tree Burning Simulator Results by Eric Sohel**
###### 4/10/2022
###### APCS
###### Mr. Konstantinovich  

--------------------------------------------------------------------------
##### **1) Why did you choose the board size for your finalized table?**
I chose the board size of 450 because it allowed me to see a clear pattern which was consistent with even higher board sizes. This way I could get data that represented the overall pattern without it taking an absurd amount of time to run. I also did not choose a board size under 450 because the pattern became harder and harder to see, and I felt as if 450 was the perfect middle ground.


##### **2) Why did you choose the number of repetitions size for your finalized table?**
I chose a repetition of 100 because I felt as if this provided the most consistent data, and it did not fluctuate as much when I ran my code several times. Repetitions over 100 provided similar accuracy, but the downside was that it took too much time to run. Additionally, smaller repetitions such as 50 did not provide much accuracy when I ran my code several times.


##### **3) What did your testing show about changing the board size?**
My testing showed that by using a smaller board size the time it took to run the code decreased but it also decreased the time it took to burn. Therefore, since the numbers were all closer apart, it was harder to see a distinct pattern between the different densities. On the other hand, when I decreased the board size too much, there was a much more clear pattern between the different densities, and the numbers were very spaced out. However, with higher board sizes, the code took too long to run without any added benefits.

##### **4) Knowing that there were differences based on boardsize, what was the relationship between the board size and the maximum burn time? How did you test this?**


Increasing the board size led to a higher maximum burn time. I tested this by trying 10 different board sizes from 10 to 100 inclusive, and comparing the maximum burn time for each of them. And as I expected, there was a linear correlation between the board size and the maximum burn time.


##### **5) What density of trees yields the maximum burn time?**
The density of 60% provided the maximum burn time. The data formed a pattern similar to an inverse parabola with the density 60 percent being the vertex.


***
**5 percent increases in density (450 board size + 100 reps)**

|Density|Burn Time      |
| ------------- |:-------------:|
|0.05               |1.9               |
|0.1               |2.74               |
|0.15               |4.12               |
|0.2               |5.58               |
|0.25               |7.02               |
|0.3               |9.82              |
|0.35               |13.47               |
|0.4               |18.22               |
|0.45               |28.93               |
|0.5               |49.31               |
|0.55               |129.82               |
|0.6               |1114.21               |
|0.65               |699.67               |
|0.7               |605.62              |
|0.75               |557.6               |
|0.8               |526.8               |
|0.85               |503.7               |
|0.9               |484.73               |
|0.95               |468.44               |

**1 percent increases in density in specified range (450 board size + 100 reps)**

|Density|Burn Time      |
| ------------- |:-------------:|
|0.56               |     178.61          |
|0.57               |     238.76          |
|0.58               |     399.7          |
|0.59               |     807.84          |
|0.6               |     1103.7          |
|0.61               |     983.33          |
|0.62               |     844.4          |
|0.63               |     775.26          |
|0.64               |     729.67          |
|0.65               |     701.04          |
|0.66               |     672.21          |
