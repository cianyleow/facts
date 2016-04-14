INSERT INTO auth_user
('username', 'password', 'accountExpired', 'accountLocked', 'credentialsExpired', 'accountEnabled')
VALUES
(:username, :password, :accountExpired, :accountLocked, :credentialsExpired, :accountEnabled);