export interface Student {
    id: number,
    name: String,
    sex: String,
    age: number;
}

export interface Course {
    id: number,
    name: String,
    no: String,
    description: String,
    times: String,
    teacher: String
}

export interface SpringList<T> {
    data: T[],
    message?: String,
    code: number
}

export interface SpringPage<T> {
    data: { list: T[], total: number },
    message?: String,
    code: number
}

export interface MaybatisPage<T> {
    data: { list: T[], size: number },
    message?: String,
    code: number
}

