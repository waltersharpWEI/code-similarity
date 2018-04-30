code-similarity
===============
**Copyright Hong Kong Baptist University Heterogeneous Computing Lab**

**CSharp Code Similarity** provides two implementations of code similarity detection algorithms, including **Longest Common Subsequence** & **Cosine Distance**
and is ready as a system that find the similar functions from the given function
library of a newly created Crossover script.

## Environmental Requirements

JDK 1.8+


## Instructions

use the go.java as the main function. And run it as a command line tool. given
the path of the funcions library and the path of the new function. It will output the list of similar functions.

The similarity threshold is adjustable. 

### Example
**import the fundation modle**

import fundation.BussinessLogic;

**define the path of the new funcion p1 and path of the functions libraray**

String p1 = "/Users/weilai/cscode/ax.csharp";

String p2 = "/Users/weilai/cscode/testDir";

**Call the findFuncInLib function and convey threshhold and path into it**

try {

    System.out.println(BussinessLogic.findFuncInLib(p1, p2, 0.6));

} catch (IOException e) {

    System.out.println("File or Dir Error");

}

