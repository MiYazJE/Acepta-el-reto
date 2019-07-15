#include <iostream> 
#include <algorithm> 
#include <string.h>
  
using namespace std; 
  
int main()  { 

    int casos, C, V;
    bool contiene;
	scanf("%d", &casos);
	
	for (int i = 0; i < casos; i++) {

		string generado = ""; 
		
		scanf("%d", &C);
		scanf("%d", &V);
		
		for (int j = 0; j < C; j++) generado += "C";
		for (int j = 0; j < V; j++) generado += "V";

		do {
			cout << generado;
			contiene = next_permutation(generado.begin(), generado.end());
			if (contiene) cout << " ";
		} while (contiene);		
		
		cout << endl;
	}
    
    return 0; 
} 
