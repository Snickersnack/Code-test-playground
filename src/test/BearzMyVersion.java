package test;

public class BearzMyVersion {

	public String equalPiles(int a, int b, int c){
		String ret = "";
        if((a+b+c)%3 != 0){
			ret = "impossible";
            return ret;
		}
		else if(a==b && b==c){
		ret = "possible";
        return ret;
        }
		else{
			int gcdOfAB = gcd(a,b);
			int gcdOfABC = gcd(gcdOfAB, c);
			
			int target = (a+b+c)/3;
			if((target/gcdOfABC) % 2 == 0){
				ret = "possible";
                return ret;
			}
			else{
				ret = "impossible";
                return ret;
			}
			
		}
		
	}
	public int gcd(int a, int b){
		System.out.println(a + "," + b);
		if (b==0) return a;
		
		return gcd(b,a%b);

		
	}
}
