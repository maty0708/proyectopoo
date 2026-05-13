public class InventarioLetras {

    // atributos
    private int[] conteo;
    private int totalCount;
    private int nonZerocount;

    // constructor
    public InventarioLetras(String data){

        this.conteo = new int[26];
        this.totalCount = 0;
        this.nonZerocount = 0;

        data = data.toLowerCase();

        for(int i = 0; i < data.length(); i++){

            char c = data.charAt(i);

            if(c >= 'a' && c <= 'z'){

                int index = c - 'a';

                if(this.conteo[index] == 0){
                    this.nonZerocount++;
                }

                this.conteo[index]++;
                this.totalCount++;
            }
        }
    }

    // metodo 1
    public int size(){
        return this.totalCount;
    }

    // metodo 2
    public boolean isEmpty(){
        return this.nonZerocount == 0;
    }

    // metodo 3
    public int get(char letra){

        letra = Character.toLowerCase(letra);

        if(letra < 'a' || letra > 'z'){
            throw new IllegalArgumentException("Letra invalida");
        }

        return this.conteo[letra - 'a'];
    }

    // metodo 4
    public String toString(){

        String resultado = "[";

        for(int i = 0; i < 26; i++){

            for(int j = 0; j < this.conteo[i]; j++){

                resultado += (char)(i + 'a');
            }
        }

        resultado += "]";

        return resultado;
    }

    // metodo 5
    public char encriptarCesar(char letra){

        if(!Character.isLetter(letra)){
            return letra;
        }

        letra = Character.toLowerCase(letra);

        return (char)(((letra - 'a' + 3) % 26) + 'a');
    }

    // metodo 6
    public char desencriptarCesar(char letra){

        if(!Character.isLetter(letra)){
            return letra;
        }

        letra = Character.toLowerCase(letra);

        return (char)(((letra - 'a' - 3 + 26) % 26) + 'a');
    }

    // metodo 7
    public String encriptarPalabra(String palabra){

        String resultado = "";

        for(int i = 0; i < palabra.length(); i++){

            char c = palabra.charAt(i);

            resultado += encriptarCesar(c);
        }

        return resultado;
    }
}