UPDATE comment SET
secret = :secret,
comment = :comment,
author = :author
WHERE commentId = :id