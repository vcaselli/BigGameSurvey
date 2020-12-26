export type GamePlatform = 'XBOX' | 'PC' | 'PLAYSTION'; 
export type Game = { 
    id: number;
    title: string;
    platform: GamePlatform;
    value: number;
    label:string;
}

