/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_star_algorithm;

import java.util.Comparator;

/**
 *
 * @author lllyu
 */
public class NodeComparator implements Comparator<Node> {
    
    @Override
    public int compare(Node node1, Node node2){
        if(node1.getF()<node2.getF())return -1;
        if(node1.getF()>node2.getF()) return 1;
        return 0;
    }
    
}
