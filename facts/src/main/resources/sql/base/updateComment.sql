UPDATE comment SET
secret = :secret,
comment = :comment,
username = :username
WHERE commentId = :id