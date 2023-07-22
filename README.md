# Banking-App-Spring-Boot

![Logo](https://github.com/Meshavegas/BankingApp-Spring-Boot-/blob/master/src/main/resources/image/Banking%20Image/banking.png?raw=true)

D'après l'énoncé, l'application à développer est une application Java+Spring Boot+MySQL qui gère un système bancaire avec trois entités principales : Users, Account et Accounting Journal.

La première étape consiste à initier un projet Spring Boot et à configurer Spring Security et JWT pour assurer la sécurité de l'application.

Ensuite, les trois entités (User, Account et AccountingJournal) doivent être créées en tant qu'@Entity, avec leur propre Repository respectif.

Trois endpoints doivent être configurés via Spring Security : POST /api/signup pour créer un compte (route non sécurisée), POST /api/signin pour se connecter (route non sécurisée) et GET /api/user [header -> authorization: Bearer TOKEN] pour récupérer les détails de l'utilisateur. De plus, deux autres endpoints, POST /api/account/credit et POST /api/account/debit, doivent être sécurisés pour créditer et débiter le compte d'un utilisateur. Lorsqu'un compte est mouvementé, une ligne doit être écrite dans le journal comptable.

Enfin, la logique métier doit être implémentée pour les différents endpoints, avec l'utilisation recommandée de DTO pour retourner les données au frontend.

## Technologies Utilisées

![Logo](data:image/png;base64,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)
![Logo](data:image/png;base64,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)
![Logo](https://i0.wp.com/www.bioenergyconsult.com/wp-content/uploads/2022/07/mysql-alternatives.jpg?ssl=1)
![Logo](https://www.ambient-it.net/wp-content/uploads/2016/04/jpa200.png)
![Logo](https://atomrace.com/blog/wp-content/uploads/2016/03/jwt-json-web-token-avec-angular-js.png)
![Logo](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZaiwwUTVbO_KlkVRlqN-pfte12y3Ht-wddA&usqp=CAU)

## Run Locally

Clone the project

```bash
  git clone https://github.com/Meshavegas/BankingApp-Spring-Boot-.git
```

Go to the project directory

```bash
  cd backing
```

Install dependencies

```bash
  mvn install
```

Create database `Mysql `

```bash
  CREATE DATABASE banking;
```

Run BankingApp

```bash
  mvn run
```

## API Reference

#### singin

```http
  GET /api/signin
```

| Parameter  | Type     | Description   |
| :--------- | :------- | :------------ |
| `email`    | `string` | **Required**. |
| `password` | `string` | **Required**. |

#### Register

```http
  GET /api/signup
```

| Parameter   | Type     | Description  |
| :---------- | :------- | :----------- |
| `name`      | `string` | **Required** |
| `createdBy` | `string` |              |
| `email`     | `string` | **Required** |
| `password`  | `string` | **Required** |

#### Get Connected User details

```http
  GET /api/user
```

| Parameter | Type     | Description  |
| :-------- | :------- | :----------- |
| `Token`   | `string` | **Required** |

![Logo](https://github.com/Meshavegas/BankingApp-Spring-Boot-/blob/master/src/main/resources/image/Banking%20Image/user.PNG?raw=true)

#### Get All Account

```http
  GET /api/account/
```

| Parameter | Type     | Description                  |
| :-------- | :------- | :--------------------------- |
| `Token`   | `string` | **Required** : Beared Tokken |

![Logo](https://github.com/Meshavegas/BankingApp-Spring-Boot-/blob/master/src/main/resources/image/Banking%20Image/accounts.PNG?raw=true)

#### Credit a account

```http
  GET /api/account/credit/4?ammount=600
```

| Parameter    | Type      | Description                  |
| :----------- | :-------- | :--------------------------- |
| `Token`      | `string`  | **Required** : Beared Tokken |
| `account_id` | `Integer` | **Required**                 |
| `ammount`    | `double`  | **Required**                 |

![Logo](https://github.com/Meshavegas/BankingApp-Spring-Boot-/blob/master/src/main/resources/image/Banking%20Image/credit.PNG?raw=true)

#### Debit a account

```http
  GET /api/account/debit/4?ammount=600
```

| Parameter    | Type      | Description                  |
| :----------- | :-------- | :--------------------------- |
| `Token`      | `string`  | **Required** : Beared Tokken |
| `account_id` | `Integer` | **Required**                 |
| `ammount`    | `double`  | **Required**                 |

![Logo](https://github.com/Meshavegas/BankingApp-Spring-Boot-/blob/master/src/main/resources/image/Banking%20Image/debit.PNG?raw=true)

## License

[MIT](https://choosealicense.com/licenses/mit/)

## 🚀 About Me

I'm a full stack developer...

- **_Java_**
- **_SprintBoot_**
- **_React Js_**

## 🔗 Links

[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://porfolio-next-sigma.vercel.app/)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/Mesha-Vegas)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/meshavegas)
[![WhatsApp](https://img.shields.io/badge/whatsapp-Write%20me-yellow)](https://wa.me/message/WJBOF26AW2M6J1)

## Authors

- [@meshavegas](https://www.github.com/meshavegas)

## Roadmap

- Additional browser support

- Add more integrations
