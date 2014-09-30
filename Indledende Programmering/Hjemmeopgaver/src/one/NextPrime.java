package one;

public class NextPrime {
	
	public static int nextPrime(int n){

		int d;
		boolean isPrime = false;
		while (!isPrime){
			
			if (n < 2) return 2; 	//Mostly to take care of negative numbers
			if (n == 2) return 3; 	//only n = 2 will return the prime '3'
			n++; 					//increment 'n' in case 'n' is already a prime
			
			if (n != 2 && n % 2 == 0) continue;
			d = 3;					//reinitialize d = 3 for each iteration
			
			/*
			 * Test for divisors 'd' less than the square root of 'n'
			 * Due to the way factors of 'n' becomes rearranged after sqrt(n)*sqrt(n),
			 * there is no need to iterate more than times than necessary: 2*3 = 3*2
			*/
			
			while (n % d != 0 && d < Math.sqrt(n)) d += 2;
			if (d > Math.sqrt(n)) isPrime = true;
		}
		return n;
	}
}


 