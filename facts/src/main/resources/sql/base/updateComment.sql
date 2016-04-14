UPDATE comment SET
feedbackId = :feedbackId,
secret = :secret,
comment = :comment,
author = :author
WHERE commentId = :id