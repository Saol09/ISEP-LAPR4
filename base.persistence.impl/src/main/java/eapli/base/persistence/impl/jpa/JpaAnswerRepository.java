package eapli.base.persistence.impl.jpa;


import eapli.base.questionnaires.domain.Answer;
import eapli.base.questionnaires.repository.AnswerRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaAnswerRepository extends JpaAutoTxRepository<Answer,String,String> implements AnswerRepository {

    public JpaAnswerRepository(final String autoTx) {
        super(autoTx, "eapli.base");
    }



}
