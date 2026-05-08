public class InventarioLetras {
// atributos
    private int [] conteo;
    private int totalCount;
    private int nonZerocount;

    // constructor
    public InventarioLetras(String data){
        this.conteo = new int[26];
        this.totalCount = 0;
        this.nonZerocount = 0;

        data = data.toLowerCase();

        for(int i = 0; i < data.length();i++){
            char c = data.charAt(i);

            if (c >= 'a' && c <= 'z'){
                int index = c - 'a';

                if(this.conteo[index] == 0){
                    this.nonZerocount++;
                }
                this.conteo[index]++;
                this.totalCount++;
            }
        }
    }
}
