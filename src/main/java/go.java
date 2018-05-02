import com.zhixiangli.code.similarity.CodeSimilarity;
import com.zhixiangli.code.similarity.common.*;
import com.zhixiangli.code.similarity.strategy.*;
import fundation.BussinessLogic;
import java.io.*;

public class go {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abc";
		String b = "abc";
		String p1 = "/Users/weilai/cscode/WMACrossover.cs";
		String p2 = "/Users/weilai/cscode/exampleDir";

		//System.out.println(BussinessLogic.isTheSame(a, b, 0.2));
		//System.out.println(BussinessLogic.isTheSameFS(p1, p2, 0.6));
		
		try {
			System.out.println(BussinessLogic.findFuncInLib(p1, p2, 0.9));
		} catch (IOException e) {
			System.out.println("File or Dir Error");
		}
	}

}

