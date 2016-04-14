UPDATE download_link SET 
fileId = :fileId,
link = :link,
username = :username,
used = :used 
WHERE downloadLinkId = :id 