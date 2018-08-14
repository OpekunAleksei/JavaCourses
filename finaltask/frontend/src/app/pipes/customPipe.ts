import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'nameSplitter' })
export class NameSplitterPipe implements PipeTransform {

    transform(value: string): string {
        let result = '';
        const arr = value.split('');

        arr.forEach((element) => {
            result = result + element + ' ';
        });
        return result;
    }
}
