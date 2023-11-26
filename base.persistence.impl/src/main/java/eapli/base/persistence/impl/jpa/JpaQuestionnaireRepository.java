package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.questionnaires.domain.*;
import eapli.base.questionnaires.repository.QuestionnaireRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;


import javax.persistence.NoResultException;
import javax.persistence.Query;

public class JpaQuestionnaireRepository extends JpaAutoTxRepository<QuestionnaireString,String,String> implements QuestionnaireRepository {

    public JpaQuestionnaireRepository(final TransactionalContext autoTx) {
        super(autoTx, "eapli.base");
    }

    public JpaQuestionnaireRepository(String puname){
        super(puname, Application.settings().getExtendedPersistenceProperties(),"eapli.base");
    }

    public QuestionnaireString findByQuestId(String id) {
        try {
            long idl = Long.parseLong(id);


            Query query = super.entityManager().createQuery("SELECT p FROM QuestionnaireString p WHERE p.id=:id");
            query.setParameter("id", idl);

            QuestionnaireString questionnaire = (QuestionnaireString) query.getSingleResult();
            return questionnaire;
        } catch (NoResultException e) {
            return null;
        }
    }
}
