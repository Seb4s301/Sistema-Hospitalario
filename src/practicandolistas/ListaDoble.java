package practicandolistas;

public class ListaDoble {
    NodoDoble ini;
    NodoDoble fin;
    
    public ListaDoble() {
        this.ini = null;
        this.fin = null;
    }
    
    public void insertar2(int dato){
        NodoDoble nuevo= new NodoDoble(dato);
        
        if(ini==null){
            ini=nuevo;
            fin=nuevo;
        }else{
            fin.setSgte(nuevo);
            nuevo.setAnt(fin);
            fin=nuevo;
        }
        
    }
    
    public void imprimir2(){
        if(ini==null){System.out.println("Nodo vacio");return;}
        NodoDoble actual=ini;
        System.out.println("");
        while(actual!=null){
            System.out.print("[" + actual.getDato() + "]->");
            actual= actual.getSgte();
        }
        
    }
    
    public void impresionInversa2(){
        if(ini==null){System.out.println("Nodovacio");return;}
        
        NodoDoble actual=fin;
        
        while(actual !=null){
            System.out.println("<-["+actual.getDato()+"]");
            actual=actual.getAnt();
        }
        
        imprimir2();
    }
    
    public void insertarInicio(int dato){
        NodoDoble nuevo= new NodoDoble(dato);
        
        if(ini==null){
            ini=nuevo;
            fin=nuevo;
        }else{
            nuevo.setSgte(ini);
            ini.setAnt(nuevo);
            ini=nuevo;
        }
        
        imprimir2();
    }
    
    public void eliminarPrimero(){ 
        if(ini==null){System.out.println("Lista vacia"); return;}
        
        if(ini==fin){
            ini=null;
            fin=null;
        }else{
            ini=ini.getSgte();
            ini.setAnt(null);
        }
        
        imprimir2();
    }
    
    public void invertirImpares(){
        if(ini==null){System.out.println("lista vacia");return;}
        
        NodoDoble izq=ini;
        NodoDoble der=fin;
        
        while(izq!= der && izq.getAnt()!= der){
            
            if(izq.getDato() %2 ==0){
                izq=izq.getSgte();
                continue;
            }
            
            if(der.getDato() %2 ==0){
                der=der.getAnt();
                continue;
            }
            
            //Intercambio
            int temp = izq.getDato();
            izq.setDato(der.getDato());
            der.setDato(temp);
            
            //siguientes
            izq=izq.getSgte();
            der=der.getAnt();
        }
        
        imprimir2();
        
    }
    
    public void inversionCompleta(){
        if(ini==null){System.out.println("Lista vacia");return;}
        
        NodoDoble actual=ini;
        NodoDoble temp=null;
        
        while(actual!=null){
            temp = actual.getSgte();
            
            actual.setSgte(actual.getAnt());
            actual.setAnt(temp);
            
            actual=temp;
        }
        
        temp=ini;
        ini=fin;
        fin=temp;
        
        imprimir2();
    }
    
    
    
    
}
