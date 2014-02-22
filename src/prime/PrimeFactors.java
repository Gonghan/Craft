package prime;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

	public List<Integer> generate(int n){
		List<Integer> primes=new ArrayList<Integer>();
		if(n<=1){
			return primes;
		}
		while(n>1){
			for(int i=2;i<=n;i++){
				if(n%i==0){
					primes.add(i);
					n=n/i;
					break;
				}
			}
		}
		return primes;
	}
}
