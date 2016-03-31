SELECT file.fileId, file.name, file.extension, file.hash, file.location, file.size, file.creationTime, file.contentType FROM file INNER JOIN download_link ON file.fileId = download_link.fileId WHERE download_link.link = :link AND download_link.used = 0 LIMIT 1