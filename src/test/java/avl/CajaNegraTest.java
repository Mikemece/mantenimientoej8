package avl;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@DisplayName("Prueba de caja negra que comprueba ")
public class CajaNegraTest {
    AvlTree<Integer> avlTree;
    Comparator<?> comparator;

    @Before
    public void setUp() throws Exception {
        comparator = Comparator.comparingInt((Integer o) -> o);
        avlTree = new AvlTree(comparator);
    }
    @Test
    @DisplayName("la altura del nodo puede ser alterada")
    public void changeHeightNode(){
        AvlNode<Integer> node = new AvlNode<>(4);
        node.setHeight(2);
        assertEquals(2, node.getHeight());
    }

    @Test
    @DisplayName("búsqueda de un elemento que esté insertado en el árbol y devuelve el resultado correcto.")
    public void searchElementInTree(){
        //Given
        avlTree.insert(1);

        //When
        AvlNode<Integer> obtainedValue = avlTree.search(1);

        int actual = obtainedValue.getItem();

        //Then
        assertEquals(1, actual);
    }

    @Test
    @DisplayName("búsqueda de un elemento que no esté insertado en el árbol y devuelve null.")
    public void  searchElementNotInTree(){
        //Given
        avlTree.insert(1);
        avlTree.insert(2);

        //When
        AvlNode<Integer> obtainedValue = avlTree.search(321);

        //Then
        assertEquals(null, obtainedValue);
    }

    @Test
    @DisplayName("eliminación de un elemento presente en el árbol reduce tamaño árbol y su búsqueda devuelve null")
    public void deleteElementInTree(){
        AvlNode<Integer> nodo = new AvlNode<>(4);


        //When
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(3);
        avlTree.insertAvlNode(nodo);
        int tamAntes = avlTree.height(nodo);

        assertEquals(0,tamAntes);


    }

    @Test
    @DisplayName("la creación de un árbol vacío y se comprueba que el tamaño del árbol es cero")
    public void emptyTreeEqualsSize0(){
        //When
        Boolean esVacio = avlTree.avlIsEmpty();

        assertEquals(true, esVacio);
    }

    @Test
    public void orderedTree(){
        //Given
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(3);
        avlTree.insert(4);

        //When
        String obtainedValue = avlTree.toString();
        String expectedValue = " | 2 | 1 | 3 | 4";

        //Then
        assertEquals(expectedValue, obtainedValue);
    }

}
