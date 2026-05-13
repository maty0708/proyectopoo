public class InventarioLetras {

    // atributos
    private int[] conteo;
    private int totalCount;
    private int nonZerocount;

    // constructor
    public InventarioLetras(String data) {

        this.conteo = new int[26];
        this.totalCount = 0;
        this.nonZerocount = 0;

        data = data.toLowerCase();

        for(int i = 0; i < data.length(); i++) {

            char c = data.charAt(i);

            // revisar letras
            if(c >= 'a' && c <= 'z') {

                int index = c - 'a';

                // contar letras distintas
                if(this.conteo[index] == 0) {
                    this.nonZerocount++;
                }

                this.conteo[index]++;
                this.totalCount++;
            }
        }
    }

    // metodo 1
    public int size() {
        return this.totalCount;
    }

    // metodo 2
    public boolean isEmpty() {
        return this.nonZerocount == 0;
    }

    // metodo 3
    public int get(char letra) {

        letra = Character.toLowerCase(letra);

        // validar letra
        if(letra < 'a' || letra > 'z') {
            throw new IllegalArgumentException("Letra invalida");
        }

        return this.conteo[letra - 'a'];
    }

    // metodo 4
    public String toString() {

        String resultado = "[";

        for(int i = 0; i < 26; i++) {

            for(int j = 0; j < this.conteo[i]; j++) {

                resultado += (char)(i + 'a');
            }
        }

        resultado += "]";

        return resultado;
    }

    // metodo 5
    public char encriptarCesar(char letra) {

        if(!Character.isLetter(letra)) {
            return letra;
        }

        letra = Character.toLowerCase(letra);

        int desplazamiento = 3;

        return (char)(((letra - 'a' + desplazamiento) % 26) + 'a');
    }

    // metodo 6
    public char desencriptarCesar(char letra) {

        if(!Character.isLetter(letra)) {
            return letra;
        }

        letra = Character.toLowerCase(letra);

        int desplazamiento = 3;

        return (char)(((letra - 'a' - desplazamiento + 26) % 26) + 'a');
    }

    // metodo 7
    public String encriptarPalabra(String palabra, int desplazamiento) {

        String resultado = "";

        for(int i = 0; i < palabra.length(); i++) {

            char c = palabra.charAt(i);

            if(Character.isLetter(c)) {

                resultado += (char)(((Character.toLowerCase(c) - 'a' + desplazamiento) % 26) + 'a');

            } else {

                resultado += c;
            }
        }

        return resultado;
    }

    // metodo 8
    public String desencriptarPalabra(String palabra, int desplazamiento) {

        String resultado = "";

        for(int i = 0; i < palabra.length(); i++) {

            char c = palabra.charAt(i);

            if(Character.isLetter(c)) {

                resultado += (char)(((Character.toLowerCase(c) - 'a' - desplazamiento + 26) % 26) + 'a');

            } else {

                resultado += c;
            }
        }

        return resultado;
    }

    // metodo 9
    public void set(char letra, int valor) {

        letra = Character.toLowerCase(letra);

        // validar letra
        if(letra < 'a' || letra > 'z') {
            throw new IllegalArgumentException("Letra invalida");
        }

        // validar valor
        if(valor < 0) {
            throw new IllegalArgumentException("Valor invalido");
        }

        int index = letra - 'a';

        int viejo = this.conteo[index];

        // actualizar total
        this.totalCount += (valor - viejo);

        // actualizar letras distintas
        if(viejo == 0 && valor > 0) {
            this.nonZerocount++;
        }

        if(viejo > 0 && valor == 0) {
            this.nonZerocount--;
        }

        this.conteo[index] = valor;
    }

    // metodo 10
    public InventarioLetras add(InventarioLetras otro) {

        InventarioLetras nuevo = new InventarioLetras("");

        for(int i = 0; i < 26; i++) {

            nuevo.conteo[i] = this.conteo[i] + otro.conteo[i];

            nuevo.totalCount += nuevo.conteo[i];

            if(nuevo.conteo[i] > 0) {
                nuevo.nonZerocount++;
            }
        }

        return nuevo;
    }

