SELECT commentId, feedbackId, secret, comment, creationTime, author FROM comment WHERE commentId IN (:ids)