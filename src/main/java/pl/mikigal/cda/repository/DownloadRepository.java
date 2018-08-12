package pl.mikigal.cda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mikigal.cda.entity.DownloadEntity;

@Repository
public interface DownloadRepository extends CrudRepository<DownloadEntity, Integer> {
}