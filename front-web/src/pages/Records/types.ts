export type RecordsReponse = {
    content: RecordItem[],
    totalPages: number;

}

export type RecordItem = { 
    id: number, 
    moment: string, 
    name: string,
    age: number, 
    gameTitle:string,
    gamePlatform: Platform,
    gameGenre: string
}

export type Platform = 'XBOX' | 'PC' | "PLAYSTION";