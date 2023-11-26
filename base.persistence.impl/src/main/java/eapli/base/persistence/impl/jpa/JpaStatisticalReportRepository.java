package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.questionnaires.domain.StatisticalReport;
import eapli.base.questionnaires.repository.StatisticalReportRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaStatisticalReportRepository extends JpaAutoTxRepository<StatisticalReport, Long, Long> implements StatisticalReportRepository {

    /*public JpaStatisticalReportRepository(final TransactionalContext autoTx) {
        super(autoTx, "eapli.base");
    }*/

    public JpaStatisticalReportRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");

    }
}
