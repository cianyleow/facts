UPDATE file SET
name = :name,
extension = :extension,
hash = :hash,
location = :location,
size = :size,
username = :username,
contentType = :contentType
WHERE fileId = :id