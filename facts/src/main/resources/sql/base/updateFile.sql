UPDATE file SET
name = :name,
extension = :extension,
hash = :hash,
location = :location,
size = :size,
contentType = :contentType
WHERE fileId = :id