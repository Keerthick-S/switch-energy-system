export interface Token {
    token : string;
    role : string;
    userId : string
}

export interface Login {
    userName : string | null | undefined,
    password : string | null | undefined
}