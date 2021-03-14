public class RetanguloApp{
    public static void main(String[] args) {
        Retangulo r = new Retangulo(12,12,10,10);
        
        //r.print();
        System.out.format("Retangulo de area: %d\n",r.area());
        r.drag(4, 5);
        System.out.println("Retangulo movido!");
        r.print();
    }
}
class Retangulo{
    int altura,largura,x,y;
    Retangulo(int altura,int largura,int x, int y){
        this.altura=altura;
        this.largura=largura;
        this.x=x;
        this.y=y;
    }
    void print(){
        System.out.format("Retangulo de tamanho (%d,%d) na posição (%d,%d) \n",this.largura,this.altura,this.x,this.y);
    }
    int area(){
        int a=(this.largura * this.altura)/2;
        return a;
    }
    void drag (int dx, int dy){
        this.x=this.x+dx;
        this.y=this.y+dy;
    }

}
