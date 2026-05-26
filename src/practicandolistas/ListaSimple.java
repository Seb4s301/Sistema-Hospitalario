package practicandolistas;


public class ListaSimple {
    private Nodo ini, fin;
    
    public ListaSimple(){
        this.ini=null;
        this.fin=null;
    }
    
    public void insertar(int dato){
        Nodo nuevo = new Nodo(dato);
        
        if(ini==null){
            ini=nuevo;
            fin=nuevo;
        }else{
            fin.setSgte(nuevo);
            fin=nuevo;
        }
        
    }
    
    public void imprimir(){
        if(ini==null){
            System.out.println("Lista vacia");
            return;
        }
        Nodo actual=ini;
        System.out.println("");
        while(actual!=null){
            System.out.print("["+actual.getDato()+"]->");
            actual=actual.getSgte();
        }
    
    }
    
    public void eliminar(int objetivo){
        if(ini==null){  System.out.print("Lista vacia"); return; }
        
        if(ini.getDato()==objetivo){ 
            ini= ini.getSgte(); 
            if(ini==null) fin=null;
            return;
        }
        
        Nodo actual = ini.getSgte();
        Nodo anterior=ini;
        
        while(actual!=null){
            
            if(actual.getDato()==objetivo){
                anterior.setSgte(actual.getSgte());
                
                if(fin.getDato()==objetivo){
                    fin=anterior;
                }
                
                return;
            }
            anterior=actual;
            actual=actual.getSgte();
            
        }
       
    }
    
    public double promedio(){
        if(ini==null){ System.out.println("Lista vacia");return 0;}
        
        Nodo actual = ini;
        int cantidad=0;
        int total=0;
        double promedio;
        
        while(actual!=null){
            total=actual.getDato()+total;
            cantidad++;
            actual = actual.getSgte();
        }
        
        promedio=(double)total/cantidad;
        System.out.println("\nEl promedio es: "+promedio);
        return promedio;
        
        }
        
    
    
    public int sumar(){
        if(ini==null){System.out.println("Lista vacia");return 0;}
        
        Nodo actual =ini;
        int total=0;
        
        while(actual!=null){
            total=actual.getDato()+total;
            
            actual= actual.getSgte();
        }
        
        System.out.println("La suma total es: "+total);
        return total;
        
    }
    
    
    public void MayorMenor(){
        if(ini==null){System.out.println("lista vacia");return;}
        
        Nodo actual=ini;
        int mayor=ini.getDato();
        int menor=ini.getDato();
        
        
        while(actual!=null){
            if(actual.getDato()>mayor){
                mayor=actual.getDato();
            }
            
            if(actual.getDato()<menor){
                menor=actual.getDato();
            }
            
            actual=actual.getSgte();
            
        }
        System.out.println("mayor:"+mayor);
        System.out.println("menor"+menor);
        return;
        
    }
    
    public void cantidadMayorMenorPromedio(){
        if(ini==null){System.out.println("lista vacia");return;}
        
        int menorIguales=0;
        int mayor=0;
        double prom =promedio();
        
        Nodo actual = ini;
        
        while(actual!=null){
            
            if(actual.getDato()>prom){
                mayor++;
            }else{
                menorIguales++;
            }
            actual= actual.getSgte();
            
        }
        
        System.out.println("Mayores: "+mayor);
        System.out.println("Menores: "+menorIguales);
        return;
        
    }
    
    public void ordenamiento(){
        if(ini==null){System.out.println("lista vacia");return;}
        
        Nodo actual=ini;
        
        while(actual!=null){
            Nodo sgte = actual.getSgte();
            
            while(sgte!=null){
                if(actual.getDato()>sgte.getDato()){
                    int temp = actual.getDato();
                    actual.setDato(sgte.getDato());
                    sgte.setDato(temp);
                }
                
                sgte = sgte.getSgte();
            }
            
            actual = actual.getSgte();
        }
        
        System.out.println("Lista ordenada:");
        imprimir();
        return;
    }
    
    public void insertarInicio(int dato){
        Nodo nuevo = new Nodo(dato);
        
        if(ini==null){
            ini=nuevo;
            fin=nuevo;
        }else{
            nuevo.setSgte(ini);
            ini=nuevo;
        }
        
    }
    
    public void InsertarEnPocision(int posicion,int dato){
        if(posicion==0){ insertarInicio(dato); return; }
        
        Nodo actual=ini;
        int contador=0;
        
        while(actual!=null&& contador < posicion-1){
            contador++;
            actual=actual.getSgte();
        }
        
        if(actual==null){
            System.out.println("\nPosicion no encontrada");
            return;
        }
        
        if(actual==fin){
            insertar(dato);
            return;
        }
        
        Nodo nuevo =new Nodo(dato);
        
        nuevo.setSgte(actual.getSgte());
        actual.setSgte(nuevo);
        
    }
    
}

