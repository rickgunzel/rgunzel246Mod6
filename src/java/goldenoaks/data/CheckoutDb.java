package goldenoaks.data;

import goldenoaks.business.Checkout;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



public class CheckoutDb {
@PersistenceContext(unitName="goldenOaksPU")

    public static void checkoutBook(Checkout checkout) {
       EntityManager em = DBUtil.getEmFactory().createEntityManager();
       EntityTransaction trans= em.getTransaction();
       trans.begin();
       try{
        em.persist(checkout);
        trans.commit();
       }catch(Exception e){
           System.out.println(e);
           trans.rollback();   
       }finally{
           em.close();
       }  
        
    }

    public static List<Checkout> selectCheckedOutBooks() {
        //TODO: Add code to select all checked out books.
         EntityManager em = DBUtil.getEmFactory().createEntityManager();
         String query="SELECT c FROM Checkout AS c ";
         TypedQuery<Checkout> q=em.createQuery(query, Checkout.class);
         List<Checkout> checkout;
         try{
             checkout= q.getResultList();
             if(checkout==null|| checkout.isEmpty())
                 checkout=null;
         }finally{
             em.close();
         }
         
        return checkout;
    }

    public static void checkinBook(long checkoutNumber) {
        //TODO: Add code to check in a book.
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        Checkout checkout = em.find(Checkout.class, checkoutNumber);
        em.getTransaction().begin();
        em.remove(em.merge(checkout));
        em.getTransaction().commit();
    }
}
