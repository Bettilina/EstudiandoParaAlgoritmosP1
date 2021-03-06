/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
* UNIDAD TEMÁTICA 3 – DICCIONARIOS, MAPAS & HASHING
* PRACTICOS DOMICILIARIOS INDIVIDUALES - 5
* EJERCICIO 1
* 
* Ahora que conocemos la librería de colecciones de JAVA, deseamos mejorar nuestra implmentación
* del TRIE que realizamos en la Unidad Temática 2, para hacerla más flexible y fácilmente adaptable a
* diferentes alfabetos y contextos.
* 
* Se propone entonces utilizar, como forma de almacenamiento de los enlaces a los subárboles en los
* nodos del TRIE, una estructura de HASHMAP.
* 
* Utilizando entonces los ejemplos y código de la UT2, desarrolla:
*
* • Nuevas clases TTrieHashMap y TNodoTrieHashMap (ésta última utiliza para la
* representación un hashMap, en vez del vector fijo )
* • Adapta los métodos de inserción, búsqueda, búsqueda de prefijos (“predecir”) y búsqueda
* de patrones (vistos en la aplicación de tries como árboles de sufijos)
* • Implementa nuevamente la aplicación de “autocompletar” , utilizando estas nuevas clases, y
* haz las pruebas que estimes convenientes.
* • Implementa también la aplicación para la búsqueda de patrones en un cierto texto,
* indicando las posiciones del texto en que ocurren
*
 */
package UT3.Rep5Ej1;

/**
 *
 * @author Bettina
 */
public class MainPruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TTrieHashMap trie = new TTrieHashMap();
        TTrieHashMap trieSufijos = new TTrieHashMap();
        String texto1 = "panamabananas";

        //Prueba sufijos
        for (int i = (texto1.length() - 1); i > -1; i--) {
            String sufijo = texto1.substring(i, texto1.length());
            trieSufijos.insertar(sufijo, i);
        }
        trieSufijos.ocurrenciasPosicionesPatron("ana");
        trieSufijos.contarPal();
        trieSufijos.alturaTrie();

        //ProbandoTrie
        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("./src/UT3/Rep5Ej1/palabras.txt");
        for (String p : palabrasclave) {
            trie.insertar(p, 0);
        }
        trie.buscar("alabachetebonete");
        trie.imprimir();
        trie.buscarNodoTrie("ala");
        System.out.println(trie.ocurrenciasPosicionesPatron("a"));
    }

}
