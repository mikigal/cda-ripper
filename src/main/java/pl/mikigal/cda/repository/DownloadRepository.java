package pl.mikigal.cda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mikigal.cda.entity.DownloadEntity;

import java.util.List;

@Repository
public interface DownloadRepository extends CrudRepository<DownloadEntity, Integer> {
    public DownloadEntity findFirstByIpOrderByDateDesc(String ip);
}