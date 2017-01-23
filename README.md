# Analysis of Modified Run Length Encoding Scheme with Introduction of Bit Stuffing for efficient Data Compression

**Run Length Encoding:**

[Run-length encoding (RLE)](https://en.wikipedia.org/wiki/Run-length_encoding) is a very simple form of [lossless data compression](https://en.wikipedia.org/wiki/Lossless_compression) in which *runs* of data (that is, sequences in which the same data value occurs in many consecutive data elements) are stored as a single data value and count, rather than as the original run. This is most useful on data that contains many such *runs*. Consider, for example, simple graphic images such as icons, line drawings, and animations. It is not useful with files that don't have many runs as it could greatly increase the file size.

**Example:**

Consider a screen containing plain black text on a solid white background. There will be many long runs of white [pixels](https://en.wikipedia.org/wiki/Pixel) in the blank space, and many short runs of black pixels within the text. A hypothetical [scan line](https://en.wikipedia.org/wiki/Scan_line), with **B** representing a black pixel and **W** representing white, might read as follows:

```markup
WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW  
```

With a run-length encoding (RLE) data compression algorithm applied to the above hypothetical scan line, it can be rendered as follows:

```markup
12W1B12W3B24W1B14W 
```

**Abstract:**

This paper presents a modified scheme for run length encoding. A significant improvement in compression ratio for almost any kind of data can be achieved by the proposed  scheme. All the limitations and problems in the original run length encoding scheme have been highlighted and discussed in detail in this research paper. A proposed solution has been suggested and performed for each problem to achieve intelligent  and  efficient  coding. One of the  major  problems with original design is that a larger number of bits are used to represent length of each run. This has been resolved by introducing bit stuffing in **RLE**. Such larger sequences that affects compression ratio are broken into small sequences using bit stuffing. To allow more compression and flexibility, the length of maximum allowable bit sequence is not fixed and can be adjusted with input. Secondly we ignore the large numbers of small sequences that are largely responsible for expansion of data instead of compression. Four random sequences have been analyzed and when applied by modified scheme, a compression ratio of as high as 50% is observed. 

**References:**

  * [Run Length Encoding - Wikipedia.](http://en.wikipedia.org/wiki/Run-length_encoding)
  * [Run Length Encoding - GeeksForGeeks.](http://www.geeksforgeeks.org/run-length-encoding/)
  * [Modified Run Length Encoding - IEEE Paper.](http://ieeexplore.ieee.org/stamp/stamp.jsp?arnumber=6148417)

**Authors:**

  * Asjad Amin
  * Haseeb Ahmad Qureshi
  * Muhammad Junaid
  * Muhammad Yasir Habib
  * Waqas Anjum
  
*This project is a direct implementation of the IEEE Paper after a through Analysis of the Algorithm and related concepts.*
