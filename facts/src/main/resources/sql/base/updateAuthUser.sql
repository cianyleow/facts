UPDATE auth_user SET
password = :password,
accountExpired = :accountExpired,
accountLocked = :accountLocked,
credentialsExpired = :credentialsExpired,
accountEnabled = :accountEnabled
WHERE username = :id