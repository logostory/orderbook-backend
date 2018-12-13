-- size 256 to 196 maybe mysql charset is UTF8mb4
create table IF NOT EXISTS oauth_client_details (
  client_id VARCHAR(191) PRIMARY KEY,
  resource_ids VARCHAR(191),
  client_secret VARCHAR(191),
  scope VARCHAR(191),
  authorized_grant_types VARCHAR(191),
  web_server_redirect_uri VARCHAR(191),
  authorities VARCHAR(191),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(191)
  );

create table IF NOT EXISTS oauth_client_token (
  token_id VARCHAR(191),
  token LONG VARBINARY,
  authentication_id VARCHAR(191) PRIMARY KEY,
  user_name VARCHAR(191),
  client_id VARCHAR(191)
  );

create table IF NOT EXISTS oauth_access_token (
  token_id VARCHAR(191),
  token LONG VARBINARY,
  authentication_id VARCHAR(191) PRIMARY KEY,
  user_name VARCHAR(191),
  client_id VARCHAR(191),
  authentication LONG VARBINARY,
  refresh_token VARCHAR(191)
  );

create table IF NOT EXISTS oauth_refresh_token (
  token_id VARCHAR(191),
  token LONG VARBINARY,
  authentication LONG VARBINARY
  );

create table IF NOT EXISTS oauth_code (
  code VARCHAR(191), authentication LONG VARBINARY
  );

create table IF NOT EXISTS oauth_approvals (
  userId VARCHAR(191),
  clientId VARCHAR(191),
  scope VARCHAR(191),
  status VARCHAR(10),
  expiresAt TIMESTAMP,
  lastModifiedAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  );

-- customized oauth_client_details table
create table IF NOT EXISTS ClientDetails (
  appId VARCHAR(191) PRIMARY KEY,
  resourceIds VARCHAR(191),
  appSecret VARCHAR(191),
  scope VARCHAR(191),
  grantTypes VARCHAR(191),
  redirectUrl VARCHAR(191),
  authorities VARCHAR(191),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additionalInformation VARCHAR(4096),
  autoApproveScopes VARCHAR(191)
  );

INSERT INTO `oauth_client_details`(
  `client_id`,
  `resource_ids`,
  `client_secret`,
  `scope`,
  `authorized_grant_types`,
  `web_server_redirect_uri`,
  `authorities`,
  `access_token_validity`,
  `refresh_token_validity`,
  `additional_information`,
  `autoapprove`
)

VALUES(
        'orderbook',
        'orderbook-api',
        '{bcrypt}$2a$04$9/ynsBPAOI1YrFm9WXE01eadMSI/nhV9yRVRaqMqviyWI4QFqJkca',
        'read,write',
        'password,refresh_token',
        '',
        null,
        864000,
        1296000,
        null,
        'false'
      );